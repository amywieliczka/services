/**
 *  This document is a part of the source code and related artifacts
 *  for CollectionSpace, an open source collections management system
 *  for museums and related institutions:

 *  http://www.collectionspace.org
 *  http://wiki.collectionspace.org

 *  Copyright 2010 University of California at Berkeley

 *  Licensed under the Educational Community License (ECL), Version 2.0.
 *  You may not use this file except in compliance with this License.

 *  You may obtain a copy of the ECL 2.0 License at

 *  https://source.collectionspace.org/collection-space/LICENSE.txt

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.collectionspace.services.common.security;

import org.collectionspace.authentication.AuthN;
import org.collectionspace.authentication.CSpaceTenant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author
 */
public class SecurityContextImpl implements SecurityContext {

    final Logger logger = LoggerFactory.getLogger(SecurityContextImpl.class);
    private String userId;
    private CSpaceTenant[] tenants = new CSpaceTenant[0];
    private String[] tenantIds = new String[0];

    public SecurityContextImpl() {
        userId = AuthN.get().getUserId();
        tenantIds = AuthN.get().getTenantIds();
        tenants = AuthN.get().getTenants();
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getCurrentTenantId() {
        return tenantIds[0];
    }

    @Override
    public String getCurrentTenantName() {
        return tenants[0].getName();
    }
}