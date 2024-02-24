package com.example.funfacts.ui


import androidx.lifecycle.ViewModel

class FactsViewModel: ViewModel() {

    fun generateRandomFacts(selectedAnimal:String):String{
       return if(selectedAnimal == "Dog"){
            getDogFacts().random()
        }
        else{
            getCatFacts().random()
        }

    }

    fun getDogFacts(): List<String>{
        val dogFacts = listOf(
            "Dogs are descendants of wolves and were domesticated between 20,000 and 40,000 years ago.",
            "The Basenji dog is known as the \"barkless dog\" because it doesn't bark like other dogs.",
            "A dog's sense of smell is incredibly powerful and is used in various fields, including search and rescue.",
            "Dogs have three eyelids. The third eyelid, known as a nictitating membrane or \"haw,\" helps keep the eye moist and protected.",
            "The world's smallest dog breed is the Chihuahua, while the largest is the Great Dane.",
            "Dogs have unique nose prints, much like human fingerprints, and can be used to identify them.",
            "The Greyhound is the fastest dog breed and can run up to 45 miles per hour.",
            "Dogs dream, and their brains exhibit similar patterns to humans during REM sleep.",
            "Dalmatians are born completely white and develop their spots as they age.",
            "The Basenji is the only dog breed that cannot bark but makes a unique yodel-like sound called a \"barroo.\""
        )
        return dogFacts
    }

    fun getCatFacts(): List<String>{
        val catFacts = listOf(
            "Cats have a unique grooming pattern called allogrooming, where they lick each other to strengthen social bonds.",
            "A group of cats is called a clowder, and a litter of kittens is sometimes referred to as a kindle.",
            "Cats have retractable claws that they use for hunting, climbing, and self-defense.",
            "The world's oldest known breed is the Egyptian Mau, dating back to 1550 B.C.",
            "Cats have a special reflective layer behind their retinas called the tapetum lucidum, enhancing their night vision.",
            "The world's longest domestic cat on record is a Maine Coon named Stewie, measuring over 48 inches long.",
            "Cats have a unique way of communicating with humans through a combination of meows, purrs, and body language.",
            "The Guinness World Record for the most kittens born by one cat is held by a Burmese cat named Tarawood Antigone, with 420 kittens.",
            "A cat's whiskers are highly sensitive and can detect changes in air currents, helping them navigate in the dark.",
            "Cats sleep for an average of 12-16 hours a day, conserving energy for hunting and play.",
            "The world's wealthiest cat is a black cat named Blackie, who inherited £7 million from his owner in 1988."
        )
        return catFacts
    }
}