package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.mail;

import com.rifqimuhammadaziz.apimedicalrecordsystem.model.request.UserDTO;

public interface MailService {
    void sendMailTest();
    void sendMailCreateUser(UserDTO userDTO);
}
