package com.codionics.spark.graphex.domain

case class Distance(
    src: String,
    dst: String,
    relationship: String,
    cost: Int
)
