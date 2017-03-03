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
package org.onosproject.store.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.util.BitSet;

/**
 * Kryo serializer for {@link BitSet}.
 */
public class BitSetSerializer extends Serializer<BitSet> {

    /**
     * Creates {@link BitSet} serializer instance.
     */
    public BitSetSerializer() {
        super(false, true);
    }

    @Override
    public void write(Kryo kryo, Output output, BitSet bitSet) {
        final int len = bitSet.length();

        output.writeInt(len, true);

        for (int i = 0; i < len; i++) {
            output.writeBoolean(bitSet.get(i));
        }
    }

    @Override
    public BitSet read(Kryo kryo, Input input, Class<BitSet> aClass) {
        final int len = input.readInt(true);
        final BitSet ret = new BitSet(len);

        for (int i = 0; i < len; i++) {
            ret.set(i, input.readBoolean());
        }

        return ret;
    }
}
