/**
 * Copyright 2013 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.dispatch.rest.client;

import com.google.gwt.http.client.Response;
import com.gwtplatform.dispatch.rest.shared.RestAction;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Deserializes a response for a given action.
 */
public interface RestResponseDeserializer {
    /**
     * Deserializes the provided <code>response</code> for the given <code>action</code>.
     *
     * @param action te action associated with the response to deserialize.
     * @param response the response to deserialize.
     * @param <A> the {@link com.gwtplatform.dispatch.rest.shared.RestAction} type.
     * @param <R> the result type.
     * @return the deserialized object.
     * @throws ActionException if an exception occurred while deserializing the response.
     */
    <A extends RestAction<R>, R> R deserialize(A action, Response response) throws ActionException;
}
