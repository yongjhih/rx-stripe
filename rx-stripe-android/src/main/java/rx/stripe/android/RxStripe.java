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
package rx.stripe.android;

import android.support.annotation.Size;

import com.stripe.android.Stripe;
import com.stripe.android.model.AccountParams;
import com.stripe.android.model.BankAccount;
import com.stripe.android.model.Card;
import com.stripe.android.model.Source;
import com.stripe.android.model.SourceParams;
import com.stripe.android.model.StripePaymentSource;
import com.stripe.android.model.Token;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;

public class RxStripe {
    @NonNull
    public static Single<Token> createToken(@NonNull final Stripe stripe,
                                            @NonNull final Card card) {
        return Single.fromCallable(
                new Callable<Token>() {
                    @NonNull
                    @Override
                    public Token call() throws Exception {
                        return stripe.createTokenSynchronous(card);
                    }
                });
    }

    @NonNull
    public static Single<Token> createToken(@NonNull final Stripe stripe,
                                            @NonNull final Card card,
                                            @NonNull final String publishableKey) {
        return Single.fromCallable(
                new Callable<Token>() {
                    @NonNull
                    @Override
                    public Token call() throws Exception {
                        return stripe.createTokenSynchronous(card, publishableKey);
                    }
                });
    }

    @NonNull
    public static Single<Token> createAccountToken(@NonNull final Stripe stripe,
                                                   @NonNull final AccountParams accountParams) {
        return Single.fromCallable(
                new Callable<Token>() {
                    @NonNull
                    @Override
                    public Token call() throws Exception {
                        return stripe.createAccountTokenSynchronous(accountParams);
                    }
                });
    }

    @NonNull
    public static Single<Token> createBankAccountToken(@NonNull final Stripe stripe,
                                                       @NonNull final BankAccount bankAccount) {
        return Single.fromCallable(
                new Callable<Token>() {
                    @NonNull
                    @Override
                    public Token call() throws Exception {
                        return stripe.createBankAccountTokenSynchronous(bankAccount);
                    }
                });
    }

    @NonNull
    public static Single<Token> createPiiToken(@NonNull final Stripe stripe,
                                               @NonNull final String personalId) {
        return Single.fromCallable(
                new Callable<Token>() {
                    @NonNull
                    @Override
                    public Token call() throws Exception {
                        return stripe.createPiiTokenSynchronous(personalId);
                    }
                });
    }

    @NonNull
    public static Single<Source> createSource(@NonNull final Stripe stripe,
                                              @NonNull final SourceParams params) {
        return Single.fromCallable(
                new Callable<Source>() {
                    @NonNull
                    @Override
                    public Source call() throws Exception {
                        return stripe.createSourceSynchronous(params);
                    }
                });
    }

    @NonNull
    public static Maybe<Source> retrieveSource(@NonNull final Stripe stripe,
                                               @NonNull @Size(min = 1) final String sourceId,
                                               @NonNull @Size(min = 1) final String clientSecret) {
        return Maybe.fromCallable(
                new Callable<Source>() {
                    @NonNull
                    @Override
                    public Source call() throws Exception {
                        return stripe.retrieveSourceSynchronous(sourceId, clientSecret);
                    }
                });
    }

    @NonNull
    public static Completable logEvent(@NonNull final Stripe stripe,
                                       @NonNull final List<String> productUsageTokens,
                                       @NonNull final StripePaymentSource paymentSource) {
        return Completable.fromAction(
                new Action() {
                    @Override
                    public void run() throws Exception {
                        stripe.logEventSynchronous(productUsageTokens, paymentSource);
                    }
                });
    }
}
