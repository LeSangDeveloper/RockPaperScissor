<!DOCTYPE html>
<html>
  <head>
    <title>Simple Rock Paper Scissors game</title>

    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
    <!-- 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"
    /> -->
  </head>
  <body>
    <!-- STARTING SCREEN -->
    <header class="main-header">
      <div class="container">
        <h1>
          <span>Rock,</span>
          <span>Paper,</span>
          <span>Scissors</span>
        </h1>

        <p class="intro">An Epic battle</p>
      </div>

      <div class="starter-screens">
        <!-- START -->
        <div class="starter-screen start">
          <div class="medium-container">
            <button class="start button">Start</button>
          </div>
        </div>

        <!-- HOW MANY ROUNDS -->
        <!-- <div class="starter-screen choose-rounds">
          <div class="medium-container">
            <h2>How many rounds would you like to play?</h2>

            <ul>
              <li class="button" data-rounds="3" role="button">
                <span>3</span>
              </li>
              <li class="button" data-rounds="5" role="button">
                <span>5</span>
              </li>
              <li class="button" data-rounds="9" role="button">
                <span>9</span>
              </li>
              <li class="button" data-rounds="15" role="button">
                <span>15</span>
              </li>
            </ul>
          </div>
        </div> -->

        <div class="starter-screen choose-character">
          <div class="medium-container">
            <h2>Choose your character</h2>

            <ul>
              <li role="button" class="character1" data-character="character1">
                <span>Fluff fluff</span>
              </li>
              <li role="button" class="character2" data-character="character2">
                <span>Squidgy</span>
              </li>
              <li role="button" class="character3" data-character="character3">
                <span>Timmy</span>
              </li>
            </ul>
          </div>
        </div>

        <!-- CHARACTERS -->
        <!-- <div class="starter-screen choose-rival">
          <div class="medium-container">
            <h2>Choose your rival:</h2>

            <ul>
              <li role="button" class="robot1" data-character="robot1">
                <span>Eugene</span>
              </li>
              <li role="button" class="robot2" data-character="robot2">
                <span>Ada</span>
              </li>
              <li role="button" class="robot3" data-character="robot3">
                <span>Turing</span>
              </li>
            </ul>
          </div>
        </div> -->
      </div>
    </header>

    <main>
      <div class="container container-collapse">
        <div class="play-area">
          <!-- PLAYER & competitor ICON -->
          <div class="players">
            <div class="player-info">
              <div class="player-character"></div>
              <p>Score: <span class="player-score">0</span></p>
            </div>

            <span>Vs.</span>

            <div class="player-info">
              <div class="competitor-character"></div>
              <p>Score: <span class="competitor-score">0</span></p>
            </div>
          </div>

          <!-- ROUND -->
          <div class="round-wrap">
            <p>
              Round: <span class="round">1</span>/<span class="best-of"></span>
            </p>
          </div>

          <!-- PLAY ARENA -->
          <div class="arena">
            <div class="player-chip">
              <h3>Your choice</h3>
              <span class="player-choice"></span>
              <div class="player-choice-icon"></div>
            </div>

            <div class="competitor-chip">
              <h3>competitor choice</h3>
              <span class="competitor-choice"></span>
              <div class="competitor-choice-icon"></div>
            </div>

            <!-- CHOOSE WEAPON -->
            <div class="weapon">
              <div class="weapon-inner">
                <h3>Choose your weapon</h3>

                <ul>
                  <li class="rock" role="button" data-weapon="rock">
                    <span>Rock</span>
                  </li>
                  <li class="paper" role="button" data-weapon="paper">
                    <span>Paper</span>
                  </li>
                  <li class="scissors" role="button" data-weapon="scissors">
                    <span>Scissors</span>
                  </li>
                </ul>
              </div>
            </div>

            <!-- ROUND RESULTS -->
            <div class="result">
              <div class="result-inner">
                <h3 class="winner"></h3>
                <button class="play-again button">Play again</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <!-- END SCREEN -->
    <section class="end-screen">
      <div class="medium-container">
        <div class="end-result"></div>

        <div class="rounds-end-screen">
          <h3>Would you like a rematch?</h3>

          <!-- <ul>
            <li class="button rounds-3" data-rounds="3" role="button">
              <span>3</span>
            </li>
            <li class="button rounds-5" data-rounds="5" role="button">
              <span>5</span>
            </li>
            <li class="button rounds-9" data-rounds="9" role="button">
              <span>9</span>
            </li>
            <li class="button rounds-15" data-rounds="15" role="button">
              <span>15</span>
            </li>
          </ul> -->
        </div>

        <button class="reset button">Rematch</button>
      </div>
    </section>
    <script
      src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"
    ></script>
    <script src="${pageContext.request.contextPath}/js/controller.js"></script>
  </body>
</html>
