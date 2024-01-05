package com.ancientjapaneseartexhibition.service;

import com.ancientjapaneseartexhibition.dto.UserRequestDto;
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
        Role defaultRole = roleRepository.findRoleBy(eRole.ROLE_USER);

        user.setFullUsername(userRequestDto.getFullUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRole(defaultRole);

        return userRepository.save(user);
    }
}
