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

package edu.iu.harp.comm.server.chainbcast;

import edu.iu.harp.comm.Connection;
import edu.iu.harp.comm.WorkerData;
import edu.iu.harp.comm.Workers;
import edu.iu.harp.comm.data.ByteArray;
import edu.iu.harp.comm.data.Commutable;
import edu.iu.harp.comm.data.StructObject;
import edu.iu.harp.comm.resource.ResourcePool;
import edu.iu.harp.comm.server.StructObjReqHandler;

public class StructObjChainBcastHandler extends ByteArrChainBcastHandler {

  public StructObjChainBcastHandler(WorkerData workerData, ResourcePool pool,
    Connection conn, Workers workers, byte command) {
    super(workerData, pool, conn, workers, command);
  }

  protected Commutable processByteArray(ByteArray byteArray) throws Exception {
    StructObject obj = StructObjReqHandler.deserializeStructObjFromBytes(
      byteArray.getArray(), byteArray.getSize(), this.getResourcePool());
    // If success, release bytes
    // Meta array doesn't exist in broadcasting struct object
    this.getResourcePool().getByteArrayPool()
      .releaseArrayInUse(byteArray.getArray());
    return obj;
  }
}
