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

import org.onosproject.net.flow.instructions.Instruction;
import org.onosproject.net.flow.instructions.Instructions;

import java.util.List;

/**
 * TrafficTreatment wrapper to disable the clearedDeferred value.
 */
public final class NoCleanTrafficTreatment implements TrafficTreatment {

    private TrafficTreatment originalTrafficTreatment;

    public NoCleanTrafficTreatment(TrafficTreatment original) {
        originalTrafficTreatment = original;
    }

    @Override
    public List<Instruction> deferred() {
        return originalTrafficTreatment.deferred();
    }

    @Override
    public List<Instruction> immediate() {
        return originalTrafficTreatment.immediate();
    }

    @Override
    public List<Instruction> allInstructions() {
        return originalTrafficTreatment.allInstructions();
    }

    @Override
    public Instructions.TableTypeTransition tableTransition() {
        return originalTrafficTreatment.tableTransition();
    }

    @Override
    public boolean clearedDeferred() {
        return false;
    }

    @Override
    public Instructions.MetadataInstruction writeMetadata() {
        return originalTrafficTreatment.writeMetadata();
    }

    @Override
    public Instructions.MeterInstruction metered() {
        return originalTrafficTreatment.metered();
    }


}
