defmodule Fitter do
  def fit1(crateX, crateY, boxx, boxy) do
    div(crateX, boxx) * div(crateY, boxy)
  end

  def fit2(crateX, crateY, boxx, boxy) do
    max(fit1(crateX, crateY, boxx, boxy),
      div(crateX, boxy) * div(crateY, boxx))
  end
end

Fitter.fit1(25, 18, 6, 5)
|> IO.puts()

Fitter.fit1(10, 10, 1, 1)
|> IO.puts()

Fitter.fit1(12, 34, 5, 6)
|> IO.puts()

Fitter.fit1(12345, 678910, 1112, 1314)
|> IO.puts()

Fitter.fit1(5, 100, 6, 1)
|> IO.puts()

Fitter.fit2(25, 18, 6, 5)
|> IO.puts()

Fitter.fit2(12, 34, 5, 6)
|> IO.puts()

Fitter.fit2(12345, 678910, 1112, 1314)
|> IO.puts()

Fitter.fit2(5, 5, 3, 2)
|> IO.puts()

Fitter.fit2(5, 100, 6, 1)
|> IO.puts()

Fitter.fit2(5, 5, 6, 1)
|> IO.puts()
