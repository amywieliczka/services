/**	
 * AccountRoleClient.java
 *
 * {Purpose of This Class}
 *
 * {Other Notes Relating to This Class (Optional)}
 *
 * $LastChangedBy: $
 * $LastChangedRevision: $
 * $LastChangedDate: $
 *
 * This document is a part of the source code and related artifacts
 * for CollectionSpace, an open source collections management system
 * for museums and related institutions:
 *
 * http://www.collectionspace.org
 * http://wiki.collectionspace.org
 *
 * Copyright (C) 2009 {Contributing Institution}
 *
 * Licensed under the Educational Community License (ECL), Version 2.0.
 * You may not use this file except in compliance with this License.
 *
 * You may obtain a copy of the ECL 2.0 License at
 * https://source.collectionspace.org/collection-space/LICENSE.txt
 */
package org.collectionspace.services.client;

import javax.ws.rs.core.Response;


import org.collectionspace.services.authorization.AccountRole;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * A AccountRoleClient.

 * @version $Revision:$
 */
public class AccountRoleClient extends AbstractServiceClientImpl {

    /**
     *
     */
    private AccountRoleProxy accountRoleProxy;

    /* (non-Javadoc)
     * @see 
     */
    public String getServicePathComponent() {
        return "accounts";
    }

    /**
     *
     * Default constructor for AccountRoleClient class.
     *
     */
    public AccountRoleClient() {
        ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
        RegisterBuiltin.register(factory);
        setProxy();
    }

    /**
     * allow to reset proxy as per security needs
     */
    public void setProxy() {
        if (useAuth()) {
            accountRoleProxy = ProxyFactory.create(AccountRoleProxy.class,
                    getBaseURL(), getHttpClient());
        } else {
            accountRoleProxy = ProxyFactory.create(AccountRoleProxy.class,
                    getBaseURL());
        }
    }


    /**
     * @param csid
     * @param arcsid relationship does not have an id, junk is fine
     * @return
     * @see 
     */
    public ClientResponse<AccountRole> read(String csid, String arcsid) {
        return accountRoleProxy.read(csid, arcsid);
    }

    /**
     * @param accRole
     * @return
     * @see 
     */
    public ClientResponse<Response> create(String csid, AccountRole accRole) {
        return accountRoleProxy.create(csid, accRole);
    }


    /**
     * @param csid
     * @param arcsid relationship does not have an id, junk is fine
     * @return
     * @see 
     */
    public ClientResponse<Response> delete(String csid, String arcsid) {
        return accountRoleProxy.delete(csid, arcsid);
    }
}