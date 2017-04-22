package io.scalajs.npm.bcrypt

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Native JS implementation of BCrypt for Node. Has the same functionality as node.bcrypt.js expect for a few tiny
  * differences. Mainly, it doesn't let you set the seed length for creating the random byte array.
  *
  * I created this version due to a small problem I faced with node.bcrypt.js. Basically, to deploy one of my apps
  * which uses node.bcrypt.js on a winx64 platform, I have to force the user to download about 1.6gb of sdks, buildtools
  * and other requirements of which some fail to install ! Microsoft :(
  *
  * This code is based on javascript-bcrypt and uses [crypto] (http://nodejs.org/api/crypto.html) to create random byte arrays.
  * @version 1.0.2
  * @see https://www.npmjs.com/package/bcrypt-nodejs
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("bcrypt", JSImport.Namespace)
object Bcrypt extends Bcrypt

/**
  * BCrypt Type Definition
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Bcrypt extends js.Object {

  /**
    * Asynchronously compares the hash to the given data
    * @param data      the given data to be compared
    * @param encrypted the encrypted data to be compared to.
    * @return the promise of a result
    * @example bcrypt.compare("bacon", hash)
    */
  def compare(data: js.Any, encrypted: Hash): js.Promise[Boolean] = js.native

  /**
    * Asynchronously compares the hash to the given data
    * @param data      the given data to be compared
    * @param encrypted the encrypted data to be compared to.
    * @param callback  the error/result callback
    * @example bcrypt.compare("bacon", hash, function(err, res) {})
    */
  def compare(data: js.Any, encrypted: Hash, callback: js.Function2[BCryptError, Boolean, Any]): Unit = js.native

  /**
    * Synchronously compares the hash to the given data
    * @param data      the given data to be compared
    * @param encrypted the encrypted data to be compared to.
    * @example bcrypt.compareSync("veggies", hash); // false
    */
  def compareSync(data: js.Any, encrypted: Hash): Boolean = js.native

  /**
    * Asynchronously generates the salt
    * @return the generated salt
    */
  def genSalt(): js.Promise[Salt] = js.native

  /**
    * Asynchronously generates the salt
    * @param rounds the number of rounds to process the data for. (default - 10)
    * @return the generated salt
    */
  def genSalt(rounds: Int): js.Promise[Salt] = js.native

  /**
    * Asynchronously generates the salt
    * @param rounds   the number of rounds to process the data for. (default - 10)
    * @param callback the error/result callback
    */
  def genSalt(rounds: Int = js.native, callback: js.Function2[BCryptError, Salt, Any]): Unit = js.native

  /**
    * Synchronously generates the salt
    * @param rounds the number of rounds to process the data for. (default - 10)
    * @example bcrypt.genSaltSync(rounds)
    */
  def genSaltSync(rounds: Int = js.native): Salt = js.native

  /**
    * Returns the number of rounds used to encrypt a given hash
    * @param encrypted hash from which the number of rounds used should be extracted.
    * @return the number of rounds used to encrypt a given hash
    * @example bcrypt.getRounds(encrypted)
    */
  def getRounds(encrypted: Hash): Int = js.native

  /**
    * Asynchronously creates a hash using the given data
    * @param data the given data to be hashed
    * @param salt the salt to be used to hash the password.
    * @return the promise of the hash
    * @example bcrypt.hash(data, salt)
    */
  def hash(data: js.Any, salt: Salt): js.Promise[Hash] = js.native

  /**
    * Asynchronously creates a hash using the given data
    * @param data     the given data to be hashed
    * @param salt     the salt to be used to hash the password.
    * @param progress a callback to be called during the hash calculation to signify progress
    * @param callback a callback to be fired once the data has been encrypted.
    * @example bcrypt.hash(data, salt, progress, cb)
    */
  def hash(data: js.Any, salt: Salt, progress: js.Function, callback: js.Function2[BCryptError, Hash, Any]): Unit = js.native

  /**
    * Asynchronously creates a hash using the given data
    * @param data     the given data to be hashed
    * @param salt     the salt to be used to hash the password.
    * @param callback a callback to be fired once the data has been encrypted.
    * @example bcrypt.hash(data, salt, progress, cb)
    */
  def hash(data: js.Any, salt: Salt, callback: js.Function2[BCryptError, Hash, Any]): Unit = js.native

  /**
    * Synchronously creates a hash using the given data
    * @param data the given data to be hashed
    * @example bcrypt.hashSync("bacon")
    */
  def hashSync(data: js.Any, salt: Salt): Hash = js.native

}
