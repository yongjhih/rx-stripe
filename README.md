# rx-stripe

[![Build Status](https://api.travis-ci.org/yongjhih/rx-stripe.svg?branch=master)](https://travis-ci.org/yongjhih/rx-stripe)

## Usage

Before:

```java
Observable<Token> tokenObservable =
    Observable.fromCallable(
            new Callable<Token>() {
                @Override
                public Token call() throws Exception {
                    // When executed, this method will conduct i/o on whatever thread it is run on
                    return stripe.createTokenSynchronous(cardToCharge);
                }
            });
```

After (rx-stripe-android):

```java
Observable<Token> tokenObservable = RxStripe.createToken(stripe, cardToCharge);
```

After (rx-stripe-android-kotlin):

```kotlin
val tokenObservable: Observable<Token> = stripe.createToken(cardToCharge);
```

## Installation

```gradle
compile 'com.github.yongjhih.rx-stripe:rx-stripe-android:-SNAPSHOT'
```

or

```gradle
compile 'com.github.yongjhih.rx-stripe:rx-stripe-android-kotlin:-SNAPSHOT'
```
