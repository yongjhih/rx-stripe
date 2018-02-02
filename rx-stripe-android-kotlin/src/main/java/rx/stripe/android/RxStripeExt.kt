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
            RxStripe.createToken(this, card)

    inline fun Stripe.createToken(card: Card, publishableKey: String): Single<Token> =
            RxStripe.createToken(this, card, publishableKey)

    inline fun Stripe.createAccountToken(accountParams: AccountParams): Single<Token> =
            RxStripe.createAccountToken(this, accountParams)

    inline fun Stripe.createBankAccountToken(bankAccount: BankAccount): Single<Token> =
            RxStripe.createBankAccountToken(this, bankAccount)

    inline fun Stripe.createPiiToken(personalId: String): Single<Token> =
            RxStripe.createPiiToken(this, personalId)

    inline fun Stripe.createSource(params: SourceParams): Single<Source> =
            RxStripe.createSource(this, params)

    inline fun Stripe.retrieveSource(@Size(min = 1) sourceId: String,
                                     @Size(min = 1) clientSecret: String): Maybe<Source> =
            RxStripe.retrieveSource(this, sourceId, clientSecret)

    inline fun Stripe.logEvent(productUsageTokens: List<String>,
                               paymentSource: StripePaymentSource): Completable =
            RxStripe.logEvent(this, productUsageTokens, paymentSource)
}
