/**
 *  This document is a part of the source code and related artifacts
 *  for CollectionSpace, an open source collections management system
 *  for museums and related institutions:

 *  http://www.collectionspace.org
 *  http://wiki.collectionspace.org

 *  Copyright 2009 University of California at Berkeley

 *  Licensed under the Educational Community License (ECL), Version 2.0.
 *  You may not use this file except in compliance with this License.

 *  You may obtain a copy of the ECL 2.0 License at

 *  https://source.collectionspace.org/collection-space/LICENSE.txt
 */
package org.collectionspace.services.common.init;

import org.collectionspace.services.common.service.ServiceBindingType;
import org.collectionspace.services.common.service.InitHandler.Params.Field;
import org.collectionspace.services.common.service.InitHandler.Params.Property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.List;

/**
 * User: laramie
 * $LastChangedRevision:  $
 * $LastChangedDate:  $
 */
public class AddIndices extends InitHandler implements IInitHandler {

    final Logger logger = LoggerFactory.getLogger(AddIndices.class);

    public void onRepositoryInitialized(ServiceBindingType sbt, List<org.collectionspace.services.common.service.InitHandler.Params.Field> fields, List<Property> property) throws Exception {
          //todo: all post-init tasks for services, or delegate to services that override.
          System.out.println("\r\n\r\n~~~~~~~~~~~~~ in AddIndices.onRepositoryInitialized with ServiceBindingType: "+sbt);

        // call something like this:
        ResultSet rs = null;
        try {
            String addIndex_SQL = "UPDATE TABLE ADD KEY `tablename`.`id`...";
            rs = openResultSet(addIndex_SQL);
            if (rs != null){
                // .....
            }
        } catch (Exception e){
            throw e;
        } finally {
            closeResultSet(rs);
        }
        //call something like this: services.common.storage.DBUtils.addIndex(String tablename, String fields[]);
        //for every field that has an authRef, do ...
        //    --> Connection conn = getConnection();
        //see parameter that you need for adding indices to SQL.

    }
}