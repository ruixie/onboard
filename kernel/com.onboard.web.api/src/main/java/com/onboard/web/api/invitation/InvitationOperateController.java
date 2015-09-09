package com.onboard.web.api.invitation;

import org.elevenframework.web.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onboard.service.account.AccountService;
import com.onboard.service.security.interceptors.CompanyMemberRequired;
import com.onboard.service.security.interceptors.InvitationPermissionRequired;

@Controller
@RequestMapping("/{companyId}/invitations")
public class InvitationOperateController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/{invitationId}", method = RequestMethod.DELETE)
    @Interceptors({ InvitationPermissionRequired.class })
    public void deleteInvitation(@PathVariable("invitationId") int invitationId) {
        accountService.deleteInvitationById(invitationId);
    }

    @RequestMapping(value = "/{invitationId}", method = RequestMethod.POST)
    @Interceptors({ CompanyMemberRequired.class })
    @ResponseBody
    public ResponseEntity<Object> renewInvitation(@PathVariable("companyId") int companyId,
            @RequestParam(value = "email", required = true) String email) {
        accountService.sendInvitation(companyId, email);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
