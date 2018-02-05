/*
 * Copyright 2018 Andrew Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("NOTHING_TO_INLINE")
package rx.stripe.android

import android.support.annotation.Size
import com.stripe.android.Stripe
import com.stripe.android.model.*
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

object RxStripeExt {
    inline fun Stripe.createToken(card: Card): Single<Token> =
            Single.fromCallable { createTokenSynchronous(card) }

    inline fun Stripe.createToken(card: Card,
                                  publishableKey: String): Single<Token> =
        Single.fromCallable { createTokenSynchronous(card, publishableKey) }

    inline fun Stripe.createAccountToken(accountParams: AccountParams): Single<Token> =
        Single.fromCallable { createAccountTokenSynchronous(accountParams) }

    inline fun Stripe.createBankAccountToken(bankAccount: BankAccount): Single<Token> =
        Single.fromCallable { createBankAccountTokenSynchronous(bankAccount) }

    inline fun Stripe.createPiiToken(personalId: String): Single<Token> =
        Single.fromCallable { createPiiTokenSynchronous(personalId) }

    inline fun Stripe.createSource(params: SourceParams): Single<Source> =
        Single.fromCallable { createSourceSynchronous(params) }

    inline fun Stripe.retrieveSource(@Size(min = 1) sourceId: String,
                                     @Size(min = 1) clientSecret: String): Maybe<Source> =
        Maybe.fromCallable { retrieveSourceSynchronous(sourceId, clientSecret) }

    inline fun Stripe.logEvent(productUsageTokens: List<String>,
                               paymentSource: StripePaymentSource): Completable =
            Completable.fromAction { logEventSynchronous(productUsageTokens, paymentSource) }
}
