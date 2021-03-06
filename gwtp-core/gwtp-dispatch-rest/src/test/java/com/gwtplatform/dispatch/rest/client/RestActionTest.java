/**
 * Copyright 2014 ArcBees Inc.
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

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gwtplatform.dispatch.rest.shared.HttpMethod;
import com.gwtplatform.dispatch.rest.shared.RestParameter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.Assert.assertTrue;

public class RestActionTest {
    private static final String PARAM_NAME_1 = "someName";
    private static final String PARAM_NAME_2 = "someOtherName";
    private static final String PARAM_VALUE_1 = "someValue";
    private static final int PARAM_VALUE_2 = 7;
    private static final String PARAM_VALUE_FORMATTED_2 = "7";

    private AbstractRestAction<Void> action;

    @Before
    public void setUp() {
        action = new SecuredRestAction(HttpMethod.POST, "");
    }

    @Test
    public void addHeaderParam_null_doesNotAddParam() {
        // When
        action.addHeaderParam(PARAM_NAME_1, null);

        // Then
        assertTrue(action.getHeaderParams().isEmpty());
    }

    @Test
    public void addHeaderParam_string_addsParam() {
        // When
        action.addHeaderParam(PARAM_NAME_1, PARAM_VALUE_1);
        action.addHeaderParam(PARAM_NAME_2, PARAM_VALUE_2);

        // Then
        verifyOnlyExpectedParamsArePresent(action.getHeaderParams());
    }

    @Test
    public void addFormParam_null_doesNotAddParam() {
        // When
        action.addFormParam(PARAM_NAME_1, null);

        // Then
        assertTrue(action.getFormParams().isEmpty());
    }

    @Test
    public void addFormParam_string_addsParam() {
        // When
        action.addFormParam(PARAM_NAME_1, PARAM_VALUE_1);
        action.addFormParam(PARAM_NAME_2, PARAM_VALUE_2);

        // Then
        verifyOnlyExpectedParamsArePresent(action.getFormParams());
    }

    @Test
    public void addQueryParam_null_doesNotAddParam() {
        // When
        action.addQueryParam(PARAM_NAME_1, null);

        // Then
        assertTrue(action.getQueryParams().isEmpty());
    }

    @Test
    public void addQueryParam_string_addsParam() {
        // When
        action.addQueryParam(PARAM_NAME_1, PARAM_VALUE_1);
        action.addQueryParam(PARAM_NAME_2, PARAM_VALUE_2);

        // Then
        verifyOnlyExpectedParamsArePresent(action.getQueryParams());
    }

    private void verifyOnlyExpectedParamsArePresent(List<RestParameter> params) {
        assertThat(params)
                .hasSize(2)
                .extracting("name", "stringValue")
                .containsExactly(
                        tuple(PARAM_NAME_1, PARAM_VALUE_1),
                        tuple(PARAM_NAME_2, PARAM_VALUE_FORMATTED_2));
    }
}
