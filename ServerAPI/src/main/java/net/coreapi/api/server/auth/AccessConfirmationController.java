package net.coreapi.api.server.auth;

/**
 * Copyright (C) 2012 by Scott Byrns
 * http://github.com/scottbyrns
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * <p/>
 * Created 6/19/12 11:08 PM
 */

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.provider.AuthorizationRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.TreeMap;

//package org.springframework.security.oauth.examples.sparklr.mvc;

//import org.springframework.security.oauth2.provider.ClientDetails;
//import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * Controller for retrieving the model for and displaying the confirmation page for access to a protected resource.
 *
 * @author Ryan Heaton
 */
//@Controller
//@SessionAttributes(types = AuthorizationRequest.class)
public class AccessConfirmationController
{
//
//	private ClientDetailsService clientDetailsService;
//
//	@RequestMapping("/oauth/confirm-access")
//	public ModelAndView getAccessConfirmation(@ModelAttribute AuthorizationRequest clientAuth) throws Exception {
//		ClientDetails client = clientDetailsService.loadClientByClientId(clientAuth.getClientId());
//		TreeMap<String, Object> model = new TreeMap<String, Object>();
//		model.put("auth_request", clientAuth);
//		model.put("client", client);
//		return new ModelAndView("access_confirmation", model);
//	}
//
//	@RequestMapping("/oauth/error")
//	public String handleError(Map<String,Object> model) throws Exception {
//		// We can add more stuff to the model here for JSP rendering.  If the client was a machine then
//		// the JSON will already have been rendered.
//		model.put("message", "There was a problem with the OAuth2 protocol");
//		return "oauth_error";
//	}
//
//	@Autowired
//	public void setClientDetailsService(ClientDetailsService clientDetailsService) {
//		this.clientDetailsService = clientDetailsService;
//	}
}
