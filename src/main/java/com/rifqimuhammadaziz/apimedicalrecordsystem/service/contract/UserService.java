package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.User;
import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.UserDTO;

public interface UserService {
    User createUser(UserDTO userDTO);
}
