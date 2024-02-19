package com.ancientjapaneseartexhibition.service;

import com.ancientjapaneseartexhibition.dto.UserRequestDto;
import com.ancientjapaneseartexhibition.exception.UserEmailNotFound;
import com.ancientjapaneseartexhibition.model.Role;
import com.ancientjapaneseartexhibition.model.User;
import com.ancientjapaneseartexhibition.model.eRole;
import com.ancientjapaneseartexhibition.repository.RoleRepository;
import com.ancientjapaneseartexhibition.repository.UserRepository;
import com.ancientjapaneseartexhibition.s3.S3Service;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final S3Service s3Service;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, S3Service s3Service) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.s3Service = s3Service;
    }

    public User addUser(UserRequestDto userRequestDto) {

        User user = new User();
        Role defaultRole = roleRepository.findRoleByRole(eRole.ROLE_USER);
        checkExistsEmail(userRequestDto.getEmail());

        user.setFullUsername(userRequestDto.getFullUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRole(defaultRole);

        return userRepository.save(user);
    }

    public User updateUser(UserRequestDto userRequestDto, String email) {

        checkExistsEmail(email);
        User updatedUser = userRepository.updateUserByEmail(
                userRequestDto.getFullUsername(),
                userRequestDto.getEmail(),
                userRequestDto.getPassword(),
                userRequestDto.getRole()
        );

        return userRepository.save(updatedUser);
    }

    private void checkExistsEmail(String email) {

        userRepository.findUserByEmail(email)
                .orElseThrow(
                        () -> new UserEmailNotFound(
                                String.format("Email '%s' doesn't exist", email)
                        )
                );
    }
}