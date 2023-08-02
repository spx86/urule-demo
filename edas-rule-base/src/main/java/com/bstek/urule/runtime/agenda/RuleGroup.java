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
package com.bstek.urule.runtime.agenda;

import java.util.ArrayList;
import java.util.List;

import com.bstek.urule.action.ActionValue;
import com.bstek.urule.model.rule.Rule;
import com.bstek.urule.model.rule.RuleInfo;
import com.bstek.urule.runtime.rete.Context;
/**
 * @author Jacky.gao
 * @since 2015年1月2日
 */
public abstract class RuleGroup {
	private String name;
	protected List<RuleInfo> executedRules;
	protected List<Activation> activations=new ArrayList<Activation>();
	public RuleGroup(String name,List<RuleInfo> executedRules) {
		this.name=name;
		this.executedRules=executedRules;
	}
	public abstract List<RuleInfo> execute(Context context,AgendaFilter filter, int max,List<ActionValue> actionValues);
	
	public static Activation fetchNextExecutableActivation(List<Activation> activations){
		Activation targetActivation=null;
		for(Activation ac:activations){
			if(!ac.isProcessed()){
				targetActivation=ac;
				break;
			}
		}
		return targetActivation;
	}
	
	public List<Activation> getActivations() {
		return activations;
	}
	public String getName() {
		return name;
	}
	public boolean contains(Rule rule){
		for(Activation activation:activations){
			if(activation.getRule().equals(rule)){
				return true;
			}
		}
		return false;
	}
}
