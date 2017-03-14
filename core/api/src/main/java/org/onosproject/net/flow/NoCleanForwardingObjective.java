/*
 * Copyright 2017-present Open Networking Laboratory
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
package org.onosproject.net.flow;

import org.onosproject.core.ApplicationId;
import org.onosproject.net.flowobjective.ForwardingObjective;
import org.onosproject.net.flowobjective.Objective;
import org.onosproject.net.flowobjective.ObjectiveContext;

import java.util.Optional;

/**
 * ForwardingObjective wrapper to disable the clearedDeferred value.
 */
public class NoCleanForwardingObjective implements ForwardingObjective {
    ForwardingObjective originalForwardingObjective;
    NoCleanTrafficTreatment noCleanTrafficTreatment;

    public NoCleanForwardingObjective(ForwardingObjective original) {
        originalForwardingObjective = original;
        noCleanTrafficTreatment = null;
    }

    @Override
    public int id() {
        return originalForwardingObjective.id();
    }

    @Override
    public int priority() {
        return originalForwardingObjective.priority();
    }

    @Override
    public ApplicationId appId() {
        return originalForwardingObjective.appId();
    }

    @Override
    public int timeout() {
        return originalForwardingObjective.timeout();
    }

    @Override
    public boolean permanent() {
        return originalForwardingObjective.permanent();
    }

    @Override
    public Operation op() {
        return originalForwardingObjective.op();
    }

    @Override
    public Optional<ObjectiveContext> context() {
        return originalForwardingObjective.context();
    }

    @Override
    public Objective.Builder copy() {
        return originalForwardingObjective.copy();
    }

    @Override
    public TrafficSelector selector() {
        return originalForwardingObjective.selector();
    }

    @Override
    public Integer nextId() {
        return originalForwardingObjective.nextId();
    }

    @Override
    public TrafficTreatment treatment() {
        if (noCleanTrafficTreatment == null)
            noCleanTrafficTreatment = new NoCleanTrafficTreatment(originalForwardingObjective.treatment());
        return noCleanTrafficTreatment;
    }

    @Override
    public Flag flag() {
        return originalForwardingObjective.flag();
    }

    @Override
    public TrafficSelector meta() {
        return originalForwardingObjective.meta();
    }
}
