/*
 * Copyright 2017 Patrick Favre-Bulle
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package at.favre.lib.bytes;

import org.junit.Before;

import java.util.Arrays;

import static org.junit.Assert.*;

public abstract class ABytesTest {
    byte[] example_bytes_seven;
    String example_hex_seven;

    byte[] example2_bytes_seven;
    String example2_hex_seven;

    byte[] example3_bytes_eight;
    String example3_hex_eight;

    byte[] example4_bytes_sixteen;
    String example4_hex_sixteen;

    @Before
    public void setUp() throws Exception {
        example_bytes_seven = new byte[]{0x4A, (byte) 0x94, (byte) 0xFD, (byte) 0xFF, 0x1E, (byte) 0xAF, (byte) 0xED};
        example_hex_seven = "4a94fdff1eafed";
        example2_bytes_seven = new byte[]{0x1E, (byte) 0x01, (byte) 0xFD, (byte) 0xAA, 0x12, (byte) 0xAF, (byte) 0x78};
        example2_hex_seven = "1e01fdaa12af78";
        example3_bytes_eight = new byte[]{(byte) 0xEE, (byte) 0xD1, (byte) 0xFD, (byte) 0xAA, 0x12, (byte) 0xAF, (byte) 0x78, 0x09};
        example3_hex_eight = "eed1fdaa12af7809";
        example4_bytes_sixteen = new byte[]{0x7E, (byte) 0xD1, (byte) 0xFD, (byte) 0xAA, 0x12, (byte) 0xAF, (byte) 0x78, 0x09, 0x1E, (byte) 0xD1, (byte) 0xFD, (byte) 0xAA, 0x12, (byte) 0xAF, (byte) 0x00, 0x0A};
        example4_hex_sixteen = "7ed1fdaa12af78091ed1fdaa12af000a";
    }

    Bytes fromAndTest(byte[] bytes) {
        Bytes b = Bytes.from(bytes);
        assertArrayEquals(bytes, b.array());
        return b;
    }

    Bytes wrapAndTest(byte[] bytes) {
        Bytes b = Bytes.wrap(bytes);
        assertSame(bytes, b.array());
        return b;
    }

    static void assertArrayNotEquals(byte[] unexpected, byte[] actual) {
        assertFalse(Arrays.equals(unexpected, actual));
    }
}