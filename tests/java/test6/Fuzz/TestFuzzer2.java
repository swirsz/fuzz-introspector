// Copyright 2022 Fuzz Introspector Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
///////////////////////////////////////////////////////////////////////////

package Fuzz;

import Function.FunctionTest;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.api.CannedFuzzedDataProvider;

public class TestFuzzer2 {
	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
		int choice = data.consumeInt(0,1);

		if (choice == 0) {
			FunctionTest ft = new FunctionTest();
			ft.function1();
		} else {
			FunctionTest.function2();
		}
	}

	public static void main(String[] args) {
                TestFuzzer2.fuzzerTestOneInput(new CannedFuzzedDataProvider("RANDOM"));
        }
}
