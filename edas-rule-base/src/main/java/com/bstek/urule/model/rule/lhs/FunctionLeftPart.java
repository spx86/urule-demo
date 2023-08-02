/*******************************************************************************
 * Copyright 2017 Bstek
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.bstek.urule.model.rule.lhs;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.bstek.urule.model.rule.Parameter;

/**
 * @author Jacky.gao
 * @since 2015年3月14日
 */
public class FunctionLeftPart implements LeftPart{
	@JsonIgnore
	private String id;
	private String name;
	private List<Parameter> parameters;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Parameter> getParameters() {
		return parameters;
	}
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	@Override
	public String getId() {
		if(id==null){
			if(parameters!=null){
				String parametersId="";
				int i=0;
				for(Parameter parameter:parameters){
					if(i>0){
						parametersId+=",";
					}
					parametersId+=parameter.getId();
					i++;
				}
				id = "[函数]."+name+"("+parametersId+")";				
			}else{
				id = "[函数]."+name;								
			}
		}
		return id;
	}
}
