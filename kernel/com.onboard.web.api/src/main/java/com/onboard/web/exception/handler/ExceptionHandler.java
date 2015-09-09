package com.onboard.web.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.onboard.domain.model.User;
import com.onboard.service.security.exception.NoPermissionException;
import com.onboard.service.web.SessionService;
import com.onboard.web.api.exception.BadRequestException;
import com.onboard.web.api.exception.InvitationTokenExpiredException;
import com.onboard.web.api.exception.InvitationTokenInvalidException;
import com.onboard.web.api.exception.NoLoginException;
import com.onboard.web.api.exception.RegisterTokenInvalidException;
import com.onboard.web.api.exception.ResetPasswordTokenInvalidException;
import com.onboard.web.api.exception.ResourceNotFoundException;

public class ExceptionHandler extends SimpleMappingExceptionResolver {

    public static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    protected void logException(Exception ex, HttpServletRequest request) {
        Integer statusCode = determineStatusCode(request, determineViewName(ex, request));
        if (statusCode / 100 == 5) {
            User currentUser = (User) request.getSession().getAttribute(SessionService.CURRENT_USER);
            if (currentUser != null) {
                MDC.put("currentUserId", String.valueOf(currentUser.getId()));
                MDC.put("currentUserName", currentUser.getName());
                MDC.put("currentUserEmail", currentUser.getEmail());
            } else {
                MDC.put("CurrentUser", "not login!");
            }
            if (ex.getStackTrace() != null && ex.getStackTrace().length > 0) {
                String loggerName = ex.getStackTrace()[0].getClassName();
                LoggerFactory.getLogger(loggerName).error(ex.getMessage(), ex);
            } else {
                logger.error(ex.getMessage(), ex);
            }
        }
        super.logException(ex, request);
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        ModelAndView mav = super.doResolveException(request, response, handler, ex);

        if (ex instanceof NoPermissionException) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            logger.info(String.valueOf(response.getStatus()));
        } else if (ex instanceof BadRequestException) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        } else if (ex instanceof NoLoginException) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        } else if (ex instanceof ResourceNotFoundException || ex instanceof InvitationTokenExpiredException
                || ex instanceof InvitationTokenInvalidException || ex instanceof RegisterTokenInvalidException
                || ex instanceof ResetPasswordTokenInvalidException) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        mav.setView(new MappingJacksonJsonView());
        mav.addObject("exception", ex);
        logger.debug("view name = {}", mav.getViewName());

        return mav;
    }
}
