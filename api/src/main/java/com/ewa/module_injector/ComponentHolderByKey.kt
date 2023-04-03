package com.ewa.module_injector

interface ComponentHolderByKey<A : BaseFeatureApi, D : BaseFeatureDependencies, K : Any> {
    var dependencyProvider: (() -> D)?
    fun get(key: K): A
}

