#!/bin/bash
# Copyright 2022 Fuzz Introspector Authors
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
################################################################################

# Ensure JDK 8.0 or later and Maven 3.3 or later is installed

ROOT=$PWD
rm -rf ./result
mkdir result

for i in {1..14}
do
  cd $ROOT/test$i
  source .config
  ./build.sh

  # Extract data
  cd $ROOT/../../frontends/java/soot
  ./run.sh -j $jarfile -c $entryclass

  for class in ${entryclass//:/ }
  do
    cp $class.result $ROOT/result/test$i-$class.result
  done
done
