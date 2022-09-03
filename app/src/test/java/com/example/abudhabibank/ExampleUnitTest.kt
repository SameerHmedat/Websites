package com.example.abudhabibank

import org.json.JSONArray
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test() {
                var json:String="[\n" +
                        "  {\n" +
                        "    \"compNameAbbrev\": \"AAPL\",\n" +
                        "    \"compName\": \"Apple Inc.\",\n" +
                        "    \"priceExchange\": \"L. 137.650  H. 143.260 Ex 100\",\n" +
                        "    \"priceTotal\": \"140.620\",\n" +
                        "    \"price_CHG\": \"Chg -2.490(-1.740%)\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"compNameAbbrev\": \"EMO\",\n" +
                        "    \"compName\": \"ClearBridge Energy Midstream Opportunity\\nFund Inc.\",\n" +
                        "    \"priceExchange\": \"L. 0.000 H. 0.000 Ex 0\",\n" +
                        "    \"priceTotal\": \"28.170\",\n" +
                        "    \"price_CHG\": \"Chg 0.000(0.000%)\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"compNameAbbrev\": \"AEM\",\n" +
                        "    \"compName\": \"Agnico Eagle Mines Ltd.\",\n" +
                        "    \"priceExchange\": \"L. 0.000 H. 0.000 Ex 0\",\n" +
                        "    \"priceTotal\": \"53.760\",\n" +
                        "    \"price_CHG\": \"Chg 0.000(0.000%)\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"compNameAbbrev\": \"AACG\",\n" +
                        "    \"compName\": \"ATA Creativity Global American Depositary \\nShares\",\n" +
                        "    \"priceExchange\": \"L. 0.000 H. 0.000 Ex 0\",\n" +
                        "    \"priceTotal\": \"1.010\",\n" +
                        "    \"price_CHG\": \"Chg 0.000(0.000%)\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"compNameAbbrev\": \"IBM\",\n" +
                        "    \"compName\": \"International Business Machines\",\n" +
                        "    \"priceExchange\": \"L. 129.420 H. 131.950 Ex 0\",\n" +
                        "    \"priceTotal\": \"130.690\",\n" +
                        "    \"price_CHG\": \"Chg 0.000(0.000%)\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"compNameAbbrev\": \"AMD\",\n" +
                        "    \"compName\": \"Advanced Micro Devices\",\n" +
                        "    \"priceExchange\": \"L. 90.920 H. 95.190 Ex 110\",\n" +
                        "    \"priceTotal\": \"93.350\",\n" +
                        "    \"price_CHG\": \"Chg -1.720(-1.809%)\"\n" +
                        "  }\n" +
                        "]"

                var jsoArr= JSONArray(json)
                val arrayStockInfo= arrayListOf<Info>()
                for(i in 0 until jsoArr.length())
                {
                    val jsonObj=jsoArr.getJSONObject(i)

                    arrayStockInfo.add(Info(
                        name = jsonObj.getString("name"),

                    )

                    )
                }
                print(arrayStockInfo)
    }
}