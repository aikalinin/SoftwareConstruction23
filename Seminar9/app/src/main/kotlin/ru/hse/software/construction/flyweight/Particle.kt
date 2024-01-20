package ru.hse.software.construction.flyweight

import kotlin.random.Random
import kotlin.system.measureTimeMillis

data class RepeatingState(val texture: String, val brightness: Double, val transparency: Double)

data class UniqueState(val velocity: Triple<Double, Double, Double>)

class Particle(private val repeatingState: RepeatingState) {

    fun move(uniqueState: UniqueState) {
        println("$repeatingState $uniqueState")
    }
}

class BadParticle(private val repeatingState: RepeatingState, val uniqueState: UniqueState) {

    fun move() {
        println("$repeatingState $uniqueState")
    }
}

class ParticleFabric {

    private val cache: MutableMap<RepeatingState, Particle> = mutableMapOf()

    fun getParticle(repeatingState: RepeatingState): Particle =
        cache[repeatingState] ?: let {
            val particle = Particle(repeatingState)
            cache[repeatingState] = particle
            particle
        }
}

class CampFire {

    private val fabric = ParticleFabric()

    fun show(numberOfParticles: Int) {
        val randomGenerator = Random(100)
        val repeatingState = RepeatingState(
            "fire",
            10.0,
            20.0
        )

        val badParticleTimeDelayMillis = measureTimeMillis {
            repeat(numberOfParticles) {
                BadParticle(
                    repeatingState, UniqueState(
                        velocity = Triple(
                            randomGenerator.nextDouble(),
                            randomGenerator.nextDouble(),
                            randomGenerator.nextDouble()
                        )
                    )
                ).move()
            }
        }

        val goodParticleTimeDelayMillis = measureTimeMillis {
            repeat(numberOfParticles) {
                val particle = fabric.getParticle(repeatingState)
                particle.move(
                    UniqueState(
                        velocity = Triple(
                            randomGenerator.nextDouble(),
                            randomGenerator.nextDouble(),
                            randomGenerator.nextDouble()
                        )
                    )
                )
            }
        }

        println("Bad particle $badParticleTimeDelayMillis millis")
        println("Good particle $goodParticleTimeDelayMillis millis")
    }
}