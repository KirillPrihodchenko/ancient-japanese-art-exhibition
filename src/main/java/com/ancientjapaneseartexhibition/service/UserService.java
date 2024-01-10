package com.ancientjapaneseartexhibition.service;

import com.ancientjapaneseartexhibition.dto.UserRequestDto;
import com.ancientjapaneseartexhibition.exception.UserEmailNotFound;
import com.ancientjapaneseartexhibition.model.Role;
import com.ancientjapaneseartexhibition.model.User;
import com.ancientjapaneseartexhibition.model.eRole;
import com.ancientjapaneseartexhibition.repository.RoleRepository;
import com.ancientjapaneseartexhibition.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User addUser(UserRequestDto userRequestDto) {

        User user = new User();
        Role defaultRole = roleRepository.findRoleByRole(eRole.ROLE_USER);

        user.setFullUsername(userRequestDto.getFullUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRole(defaultRole);

        return userRepository.save(user);
    }

    public User updateUser(UserRequestDto userRequestDto, String email) {

        existEmail(email);
        User updateUser = userRepository.updateUserByEmail(email);

        updateUser.setFullUsername(userRequestDto.getFullUsername());
        updateUser.setEmail(userRequestDto.getEmail());
        updateUser.setPassword(userRequestDto.getPassword());
        updateUser.setRole(userRequestDto.getRole());

        return userRepository.save(updateUser);
    }

    private void existEmail(String email) {

        userRepository.findUserByEmail(email)
                .orElseThrow(
                        () -> new UserEmailNotFound(
                                String.format("Email '%s' doesn't exist", email)
                        )
                );
    }
}