<template>
  <div class="summary-container">
    <h1>Summary</h1>
    <h2>Current Listings</h2>
    <p>{{ this.totalCurrentListings }}</p>
    <h2>Reservations (alltime)</h2>
    <p>{{ this.reservationsAlltime }}</p>
    <h2>Reservations (this year)</h2>
    <p>{{ this.reservationsThisYear }}</p>
    <h2>Reservations (this month)</h2>
    <p>{{ this.reservationsThisMonth }}</p>
    <h2>Cashflow (alltime)</h2>
    <p>{{ this.cashflowAlltime }} sek</p>
    <h2>Cashflow (this year)</h2>
    <p>{{ this.cashflowThisYear }} sek</p>
    <h2>Cashflow (this month)</h2>
    <p>{{ this.cashflowThisMonth }} sek</p>
    <h2>Profit (alltime)</h2>
    <p>{{ this.profitAlltime }} sek</p>
    <h2>Profit (this year)</h2>
    <p>{{ this.profitThisYear }} sek</p>
    <h2>Profit (this month)</h2>
    <p>{{ this.profitThisMonth }} sek</p>
  </div>
</template>

<script>
export default {
  async created() {
    // current date information is needed for some fetch queries below
    let currentDate = new Date()
    let currentMonth = currentDate.getMonth() + 1
    if (currentMonth < 10) {
      currentMonth = "0" + currentMonth
    }

    // run the various fetches for this page
    let res = await fetch('/api/totalCurrentListings/')
    this.totalCurrentListings =  await res.json()

    res = await fetch('/api/reservationsAlltime/')
    this.reservationsAlltime = await res.json()

    res = await fetch('/api/reservationsThisYear/' + currentDate.getFullYear())
    this.reservationsThisYear = await res.json()

    res = await fetch('/api/reservationsThisMonth/' + currentDate.getFullYear() + '/' + currentMonth)
    this.reservationsThisMonth = await res.json()

    res = await fetch('/api/cashflowAlltime/')
    this.cashflowAlltime = await res.json()

    res = await fetch('/api/cashflowThisYear/' + currentDate.getFullYear())
    this.cashflowThisYear = await res.json()

    res = await fetch('/api/cashflowThisMonth/' + currentDate.getFullYear() + '/' + currentMonth)
    this.cashflowThisMonth = await res.json()

    this.profitAlltime = Math.round(this.cashflowAlltime * .15)

    this.profitThisYear = Math.round(this.cashflowThisYear * .15)

    this.profitThisMonth = Math.round(this.cashflowThisMonth * .15)
  },

  data() {
    return {
      totalCurrentListings: null,
      reservationsAlltime: null,
      reservationsThisYear: null,
      reservationsThisMonth: null,
      cashflowAlltime: null,
      cashflowThisYear: null,
      cashflowThisMonth: null,
      profitAlltime: null,
      profitThisYear: null,
      profitThisMonth: null,
    }
  },
}
</script>

<style>

</style>