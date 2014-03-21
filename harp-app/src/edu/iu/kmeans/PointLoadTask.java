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

package edu.iu.kmeans;

import org.apache.hadoop.conf.Configuration;

import edu.iu.harp.collective.Task;
import edu.iu.harp.comm.data.DoubleArray;

public class PointLoadTask extends Task<String, DoubleArray> {

  private int pointsPerFile;
  private int vectorSize;
  private Configuration conf;

  public PointLoadTask(int pPerFile, int vSize, Configuration conf) {
    this.pointsPerFile = pPerFile;
    this.vectorSize = vSize;
    this.conf = conf;
  }

  @Override
  public DoubleArray run(String fileName) throws Exception {
    int pDataSize = pointsPerFile * vectorSize;
    return NoSyncKMeansAllReduceMapper.loadPoints(fileName, pDataSize, conf);
  }
}