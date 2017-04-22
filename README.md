Bcrypt API for Scala.js
================================
[bcrypt](https://www.npmjs.com/package/bcrypt) - A bcrypt library for NodeJS.

### Description

`bcrypt` is a password hashing function designed by Niels Provos and David Mazières, 
based on the Blowfish cipher, and presented at USENIX in 1999.

### Build Dependencies

* [SBT v0.13.13](http://www.scala-sbt.org/download.html)

### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Examples

Using `Bcrypt` asynchronously via callbacks

```scala
import io.scalajs.npm.bcrypt._

val saltRounds = 13
val myPlaintextPassword = "b@c0n"

Bcrypt.hash(myPlaintextPassword, saltRounds, (_, hash) => {
    Bcrypt.compare(myPlaintextPassword, hash, (_, isMatch) => {
      println(s"The password was a match: $isMatch") // The password was a match: true
    })
})
```

Using `Bcrypt` asynchronously via promises

```scala
import io.scalajs.npm.bcrypt._

val saltRounds = 13
val myPlaintextPassword = "b@c0n"

for {
    hash <- Bcrypt.hash(myPlaintextPassword, saltRounds)
    isMatch <- Bcrypt.compare(myPlaintextPassword, hash)
} {
  println(s"The password was a match: $isMatch") // The password was a match: true
}
```

Using `Bcrypt` synchronously

```scala
import io.scalajs.npm.bcrypt._

val saltRounds = 13
val myPlaintextPassword = "b@c0n"

val hash = Bcrypt.hashSync(myPlaintextPassword, saltRounds)
val isMatch = Bcrypt.compareSync(myPlaintextPassword, hash)
println(s"The password was a match: $isMatch") // The password was a match: true
```

### Artifacts and Resolvers

To add the `Bcrypt` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "bcrypt" % "0.4.0-pre5"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```