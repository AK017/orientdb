/*
 *
 *  *  Copyright 2010-2016 OrientDB LTD (http://orientdb.com)
 *  *
 *  *  Licensed under the Apache License, Version 2.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtrg/licenses/LICENSE-2.0
 *  *
 *  *  Unless required by applicable law or agreed to in writing, software
 *  *  distributed under the License is distributed on an "AS IS" BASIS,
 *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  See the License for the specific language governing permissions and
 *  *  limitations under the License.
 *  *
 *  * For more information: http://orientdb.com
 *
 */
package com.orientechnologies.orient.client.remote.message;

import java.io.IOException;

import com.orientechnologies.orient.client.binary.OChannelBinaryAsynchClient;
import com.orientechnologies.orient.client.remote.OBinaryResponse;
import com.orientechnologies.orient.client.remote.OStorageRemoteSession;
import com.orientechnologies.orient.enterprise.channel.binary.OChannelBinary;

public final class OAddClusterResponse implements OBinaryResponse<Integer> {
  private int clusterId;

  public OAddClusterResponse() {
  }

  public OAddClusterResponse(int num) {
    this.clusterId = num;
  }

  public void write(OChannelBinary channel, int protocolVersion, String recordSerializer) throws IOException {
    channel.writeShort((short) clusterId);
  }

  @Override
  public Integer read(OChannelBinaryAsynchClient network, OStorageRemoteSession session) throws IOException {
    this.clusterId = network.readShort();
    return clusterId;
  }

  public int getClusterId() {
    return clusterId;
  }
}