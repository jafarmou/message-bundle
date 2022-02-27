package com.example.messagebundle;

import com.example.messagebundle.config.LocaleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @Autowired
    private LocaleConfiguration localeConfiguration;

    @GetMapping("/")
    public String get() {
        String message = localeConfiguration.messageSourceDesc().getMessage("transfer.operationType.PURCHASE.MERCHANT.SMS",
                 new Object[]{25000000.00, "John"}, LocaleContextHolder.getLocale());

        String message2 = localeConfiguration.messageSourceDesc().getMessage("qr.purchase.notification.anonymous",
                new Object[0], LocaleContextHolder.getLocale());

        return message2;
    }
}
