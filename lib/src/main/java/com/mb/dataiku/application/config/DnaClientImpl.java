/* LICENSE START
 * 
 * MIT License
 * 
 * Copyright (c) 2019 Daimler TSS GmbH
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * LICENSE END 
 */

package com.mb.dataiku.application.config;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.net.HttpHeaders;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.HttpClient;
import jakarta.inject.Inject;




@Bean
public class DnaClientImpl implements DnaClient {

	private Logger LOGGER = LoggerFactory.getLogger(DnaClientImpl.class);

	@Value("${dna.uri}")
	private String dnaBaseUri;

	@Value("${dna.verifyLoginApi}")
	private String verifyLogin;

	@Value("${dna.unsubscribeMalwareScanApi}")
	private String unsubscribeMalwareScan;
	
	@Inject
	HttpRequest httpRequest;
	
	@Inject
	HttpHeaders headers;


	@Inject
	HttpClient httpclient;

	@Override
	@Header(name = "Accept", value = "application/json")
	@Header(name = "Content-Type", value = "application/json")	
	public JSONObject verifyLogin(String jwt) {
		JSONObject res = null;
		try {							
			

			String dnaUri = dnaBaseUri + verifyLogin;
			HttpEntity entity = new HttpEntity();
			HttpResponse<String> response = httpclient.exchange(dnaUri, HttpMethod.POST, entity, String.class);
			if (response != null && response.()) {
				LOGGER.debug("Success from dna verify login");
				res = (JSONObject) new JSONObject(response.getBody()).get("data");
			}
		} catch (JSONException e) {
			LOGGER.error("Error occured while parsing jsonObject for DnA verifyLogin:{}", e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.error("Error occured while calling DnA verifyLogin:{}", e.getMessage());
			throw e;
		}
		return res;
	}

	@Override
	public String updateSubscriptionAppIdInSolution(String solutionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
