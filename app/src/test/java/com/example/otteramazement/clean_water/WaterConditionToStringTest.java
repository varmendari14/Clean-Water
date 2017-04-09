package com.example.otteramazement.clean_water;

import junit.framework.Assert;
import org.junit.Test;

/**Tests the waterConditionToString(WaterCondition type) method
 * in the WaterCondition ENUM class
 *
 * Created by Avery on 4/3/2017.
 */

public class WaterConditionToStringTest {

    private final WaterCondition[] waterConditionList = {WaterCondition.WASTE, WaterCondition.TREATABLE_MUDDY,
            WaterCondition.TREATABLE_CLEAR, WaterCondition.POTABLE};

    private final String[] waterConditionCorrect = {"WASTE", "TREATABLE_MUDDY", "TREATABLE_CLEAR", "POTABLE"};

    @Test
    public void IsCorrect() {
        for (int i = 0; i < waterConditionList.length; i++) {
            Assert.assertEquals("values equal",waterConditionList[i].waterConditionToString(waterConditionList[i]),
                        waterConditionCorrect[i]);
        }
    }
}
