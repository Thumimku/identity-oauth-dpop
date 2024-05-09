/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.oauth2.dpop.cache;

import org.wso2.carbon.identity.application.authentication.framework.cache.AuthenticationBaseCache;
import org.wso2.carbon.utils.CarbonUtils;

/**
 * Cache for DPoP JKT.
 */
public class DPoPJKTCache extends AuthenticationBaseCache<DPoPJKTCacheKey, DPoPJKTCacheEntry> {

    private static final String DPOP_JKT_CACHE_NAME = "DPoPJKTCache";

    private static volatile DPoPJKTCache instance = new DPoPJKTCache();

    private DPoPJKTCache() {

        super(DPOP_JKT_CACHE_NAME);
    }

    public static DPoPJKTCache getInstance() {

        CarbonUtils.checkSecurity();
        if (instance == null) {
            synchronized (DPoPJKTCache.class) {
                if (instance == null) {
                    instance = new DPoPJKTCache();
                }
            }
        }
        return instance;
    }
}