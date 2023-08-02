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
package com.bstek.urule.runtime.rete;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.bstek.urule.debug.MessageItem;
import com.bstek.urule.runtime.WorkingMemory;

/**
 * @author Jacky.gao
 * @since 2015年3月9日
 */
public class EvaluationContextImpl extends ContextImpl implements EvaluationContext {
	private Activity prevActivity;
	public EvaluationContextImpl(WorkingMemory workingMemory,
			ApplicationContext applicationContext, 
			Map<String, String> variableCategoryMap,List<MessageItem> debugMessageItems) {
		super(workingMemory, applicationContext, variableCategoryMap,debugMessageItems);
	}
	@Override
	public Activity getPrevActivity() {
		return prevActivity;
	}
	@Override
	public void setPrevActivity(Activity activity) {
		this.prevActivity=activity;
	}
}
