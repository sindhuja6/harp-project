/*
 * Copyright 2014 Indiana University
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

package edu.iu.harp.depl;

import java.util.ArrayList;
import java.util.List;

public class CMDOutput {
	private boolean status;
	private List<String> output;

	CMDOutput() {
		status = true;
		output = new ArrayList<String>();
	}

	void setExecutionStatus(boolean isSuccess) {
		status = isSuccess;
	}

	public boolean getExecutionStatus() {
		return status;
	}

	public List<String> getExecutionOutput() {
		return output;
	}
}