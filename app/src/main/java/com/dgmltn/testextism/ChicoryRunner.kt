package com.dgmltn.testextism

import android.content.res.Resources
import com.dylibso.chicory.runtime.Module
import com.dylibso.chicory.wasm.types.Value

class ChicoryRunner(val resources: Resources) {
    fun go(): String {
        val inputStream = resources.openRawResource(R.raw.factorial)
        val module = Module.build(inputStream)
        val instance = module.instantiate()
        val iterFact = instance.getExport("iterFact")
        val result: Value = iterFact.apply(Value.i32(5))[0]
        return "${result.asInt()}" // should return 120 (5!)
    }
}