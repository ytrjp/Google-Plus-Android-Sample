/* 
 * Copyright (C) 2011 iMellon
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.imellon.android.googleplus;

import com.imellon.android.googleplus.store.SharedPreferencesCredentialStore;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;


/**
 * @author Christos Papazafeiropoulos, Dimitris Makris
 * 
 * This is the Main Screen of the application. 4 button provide the sample
 * functionalities. First step is to authenticate the user. No data presented
 * in profiles if no previous authentication.
 * 
 */

public class GooglePlusActivity extends Activity {

	private SharedPreferences preferences;

	private Button launchOauth, clearCredentials, my_profile, profiles_search;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setup();
	}

	private void setup() {
		setContentView(R.layout.activity_main);

		this.preferences = PreferenceManager.getDefaultSharedPreferences(this);

		launchOauth = (Button) findViewById(R.id.btn_launch_oauth);
		my_profile = (Button) findViewById(R.id.btn_profile);
		profiles_search = (Button) findViewById(R.id.btn_profiles);
		clearCredentials = (Button) findViewById(R.id.btn_clear_credentials);

		launchOauth.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent().setClass(v.getContext(),
						OAuthActivity.class));
			}
		});

		my_profile.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent().setClass(v.getContext(),
						MyProfileActivity.class));
			}
		});

		profiles_search.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent().setClass(v.getContext(),
						ProfilesActivity.class));
			}
		});
		
		clearCredentials.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				SharedPreferencesCredentialStore.getInstance(preferences).clearCredentials();
			}
		});
	}

}