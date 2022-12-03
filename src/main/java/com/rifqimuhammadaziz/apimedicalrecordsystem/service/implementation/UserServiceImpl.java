package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.User;
import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.UserDTO;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.UserRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.UserService;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.mail.MailService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MailService mailService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, MailService mailService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.mailService = mailService;
        this.modelMapper = modelMapper;
    }

    @Override
    public User createUser(UserDTO userDTO) {
        // Convert DTO To Entity
        User user = mapToEntity(userDTO);

        // Send Email After Create User
        mailService.sendMailCreateUser(userDTO);

        return userRepository.save(user);
    }

    private UserDTO mapToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private User mapToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
