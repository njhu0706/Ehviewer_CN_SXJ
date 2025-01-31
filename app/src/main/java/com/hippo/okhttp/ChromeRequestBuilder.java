/*
 * Copyright 2016 Hippo Seven
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
 */

package com.hippo.okhttp;

import com.hippo.ehviewer.Settings;

import okhttp3.Request;

public class ChromeRequestBuilder extends Request.Builder {

    private static final String CHROME_USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36";

    private static final String CHROME_ACCEPT =
            "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;" +
                    "q=0.8,application/signed-exchange;v=b3;q=0.9";

    private static final String CHROME_ACCEPT_LANGUAGE =
            "en-US,en;q=0.9";

    public ChromeRequestBuilder(String url) {
        String host = url.split("/")[2];
        if (Settings.getUR()&&host.endsWith("e-hentai.org")){
//            url = url.replaceFirst("e-hentai.org", "github.com");
            url = url.replaceFirst("e-hentai.org", "github.io");

        }
 // domain fronting
        url(url);
        addHeader("Host", host);
        addHeader("User-Agent", CHROME_USER_AGENT);
        addHeader("Accept", CHROME_ACCEPT);
        addHeader("Accept-Language", CHROME_ACCEPT_LANGUAGE);
    }
}
