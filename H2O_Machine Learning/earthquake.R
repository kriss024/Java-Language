rm(list = ls())
require(xlsx)

setwd("C:\\Work")

earthquake <- read.xlsx("earthquake.xlsx", 1)

summary(earthquake)

library(h2o)
h2o.init(ip = "localhost", port = 54321, nthreads = -1)

earthquake_h2o <- as.h2o(earthquake, "earthquake")
h2o.describe(earthquake_h2o)

model <- h2o.deeplearning(x = 1:2, y = 3, model_id = "deeplearning", hidden = c(8, 4, 2), epochs = 30, training_frame = earthquake_h2o)
summary(model)

h2o.download_pojo(model, get_jar = TRUE, getwd())

perf <- h2o.performance(model, earthquake_h2o)
h2o.giniCoef(perf)

response <- h2o.predict(model, earthquake_h2o)
pred <- response$predict

table <- h2o.table(pred, earthquake_h2o[, 3])
print(table)