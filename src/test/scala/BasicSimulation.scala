import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class BasicSimulation extends Simulation {

  val httpConf = http
    .baseURL("https://www.google.com")
    .headers(Map(
        HttpHeaderNames.ContentType    -> HttpHeaderValues.ApplicationJson,
        HttpHeaderNames.Accept         -> HttpHeaderValues.ApplicationJson,
        HttpHeaderNames.AcceptEncoding -> "gzip,deflate"
    ))

  val scn = scenario("Basic sinario")
    .exec(http("request_1")
      .get("/"))
    .pause(500 milliseconds)
    .exec(http("request_2")
      .get("/"))

  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))
}
