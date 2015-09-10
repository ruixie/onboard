/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.service.security.exception;

public class NoPermissionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer companyId;

    public NoPermissionException() {

    }

    public NoPermissionException(Integer companyId) {
        super();
        this.setCompanyId(companyId);
    }

    public NoPermissionException(Integer companyId, String message) {
        super(message);
        this.setCompanyId(companyId);
    }

    public NoPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPermissionException(String message) {
        super(message);
    }

    public NoPermissionException(Throwable cause) {
        super(cause);
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

}
