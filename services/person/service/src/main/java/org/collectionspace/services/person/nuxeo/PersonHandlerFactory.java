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

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.collectionspace.services.person.nuxeo;

import org.collectionspace.services.common.ClientType;
import org.collectionspace.services.common.document.DocumentHandler;
import org.collectionspace.services.common.document.DocumentHandlerFactory;


/**
 * PersonHandlerFactory creates handlers for person based
 * on type of Nuxeo client used
 *
 * $LastChangedRevision: $
 * $LastChangedDate: $
 */
public class PersonHandlerFactory implements DocumentHandlerFactory {

    private static final PersonHandlerFactory self = new PersonHandlerFactory();

    private PersonHandlerFactory() {
    }

    public static PersonHandlerFactory getInstance() {
        return self;
    }

		@Override
    public DocumentHandler getHandler(String clientType) {
        if(ClientType.JAVA.toString().equals(clientType)){
            return new PersonDocumentModelHandler();
        } 
        throw new IllegalArgumentException("Not supported client=" + clientType);
    }
}