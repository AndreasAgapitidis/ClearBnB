<template>
  <div class="summary-container">
    <div class="reservations-container">
      <h1>Reservations</h1>
      <h3>This month</h3>
      <p>{{ reservationsThisMonth }}</p>
      <h3>This year</h3>
      <p>{{ reservationsThisYear }}</p>
      <h3>All time</h3>
      <p>{{ reservationsAllTime }}</p>
    </div>
    <div class="revenue-container">
      <h1>Revenue</h1>
      <h3>This month</h3>
      <p>{{ revenueThisMonth }}</p>
      <h3>This year</h3>
      <p>{{ revenueThisYear }}</p>
      <h3>All time</h3>
      <p>{{ revenueAllTime }}</p>
    </div>
    <div class="profit-container">
      <h1>Profit</h1>
      <h3>This month</h3>
      <p>{{ profitThisMonth }}</p>
      <h3>This year</h3>
      <p>{{ profitThisYear }}</p>
      <h3>All time</h3>
      <p>{{ profitAllTime }}</p>
    </div>
    <div class="listings-container">
      <h1>Listings</h1>
      <h3>Current</h3>
      <p>{{ totalCurrentListings }}</p>
    </div>
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
    this.reservationsAllTime = await res.json()

    res = await fetch('/api/reservationsThisYear/' + currentDate.getFullYear())
    this.reservationsThisYear = await res.json()

    res = await fetch('/api/reservationsThisMonth/' + currentDate.getFullYear() + '/' + currentMonth)
    this.reservationsThisMonth = await res.json()

    res = await fetch('/api/cashflowAlltime/')
    this.revenueAllTime = await res.json()

    res = await fetch('/api/cashflowThisYear/' + currentDate.getFullYear())
    this.revenueThisYear = await res.json()

    res = await fetch('/api/cashflowThisMonth/' + currentDate.getFullYear() + '/' + currentMonth)
    this.revenueThisMonth = await res.json()

    this.profitAllTime = Math.round(this.revenueAllTime * .15)

    this.profitThisYear = Math.round(this.revenueThisYear * .15)

    this.profitThisMonth = Math.round(this.revenueThisMonth * .15)
  },

  data() {
    return {
      totalCurrentListings: null,
      reservationsAllTime: null,
      reservationsThisYear: null,
      reservationsThisMonth: null,
      revenueAllTime: null,
      revenueThisYear: null,
      revenueThisMonth: null,
      profitAllTime: null,
      profitThisYear: null,
      profitThisMonth: null,
    }
  },
}
</script>

<style scoped>
.summary-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: auto auto;
  column-gap: 1em;
  padding: 0 1em 0 1em;
  margin: auto;
  max-width: 500px;
}

.reservations-container {
  text-align: left;
}

.revenue-container {
  text-align: right;
}

.profit-container {
  text-align: left;
}

.listings-container {
  text-align: right;
}

h3 {
  margin-bottom: 8px;
}

p {
  border: 1px solid black;
  border-radius: 20px;
  padding: 14px;
  font-size: 20px;
  font-weight: bold;
  margin-top: 4px;
  text-align: center;
}

</style>