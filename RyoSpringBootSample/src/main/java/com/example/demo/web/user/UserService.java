package com.example.demo.web.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserService {
    private Log logger = LogFactory.getLog(getClass());

    @Transactional(readOnly = false)
    public void save(User user) {
        logger.info("Saved:" + user.toString());
    }

}
