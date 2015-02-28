/*    Copyright 2013 Antti Kolehmainen

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License. */
package com.sturdyhelmetgames.roomforchange.tween;

import aurelienribon.tweenengine.TweenAccessor;

import com.sturdyhelmetgames.roomforchange.entity.Entity;

public class EntityAccessor implements TweenAccessor<Entity> {

	public static final int POSITIONXY = 1;
	public static final int POSITIONX = 2;
	public static final int POSITIONY = 3;

	@Override
	public int getValues(Entity target, int tweenType, float[] returnValues) {
		switch (tweenType) {
		case POSITIONXY:
			returnValues[0] = target.bounds.x;
			returnValues[1] = target.bounds.y;
			return POSITIONXY;
		case POSITIONX:
			returnValues[0] = target.bounds.x;
			return POSITIONX;
		case POSITIONY:
			returnValues[0] = target.bounds.y;
			return POSITIONY;
		default:
			assert false;
			return -1;
		}
	}

	@Override
	public void setValues(Entity target, int tweenType, float[] newValues) {
		switch (tweenType) {
		case POSITIONXY:
			target.bounds.x = newValues[0];
			target.bounds.y = newValues[1];
			break;
		case POSITIONX:
			target.bounds.x = newValues[0];
			break;
		case POSITIONY:
			target.bounds.y = newValues[0];
			break;
		default:
			assert false;
			break;
		}
	}

}
